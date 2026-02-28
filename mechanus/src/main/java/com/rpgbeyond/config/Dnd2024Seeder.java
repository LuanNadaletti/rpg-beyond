package com.rpgbeyond.config.seed;

import com.rpgbeyond.model.entity.Background;
import com.rpgbeyond.model.entity.Class;
import com.rpgbeyond.model.entity.Species;
import com.rpgbeyond.repository.BackgroundRepository;
import com.rpgbeyond.repository.ClassRepository;
import com.rpgbeyond.repository.SpeciesRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@ConditionalOnProperty(name = "app.seed.dnd2024.enabled", havingValue = "true", matchIfMissing = false)
public class Dnd2024Seeder implements ApplicationRunner {

    private static final List<String> BACKGROUNDS = List.of(
            "Acolyte", "Artisan", "Charlatan", "Criminal", "Entertainer", "Farmer", "Guard", "Guide",
            "Hermit", "Merchant", "Noble", "Sage", "Sailor", "Scribe", "Soldier", "Wayfarer"
    );

    private static final List<String> CLASSES = List.of(
            "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk",
            "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"
    );

    private static final List<String> SPECIES = List.of(
            "Aasimar", "Dragonborn", "Dwarf", "Elf", "Gnome",
            "Goliath", "Halfling", "Human", "Orc", "Tiefling"
    );

    private final BackgroundRepository backgroundRepository;
    private final ClassRepository classRepository;
    private final SpeciesRepository speciesRepository;

    public Dnd2024Seeder(
            BackgroundRepository backgroundRepository,
            ClassRepository classRepository,
            SpeciesRepository speciesRepository
    ) {
        this.backgroundRepository = backgroundRepository;
        this.classRepository = classRepository;
        this.speciesRepository = speciesRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) {
        seedBackgrounds();
        seedClasses();
        seedSpecies();
    }

    private void seedBackgrounds() {
        Set<String> existing = backgroundRepository.findAll().stream()
                .map(b -> norm(b.getName()))
                .collect(Collectors.toSet());

        List<Background> toInsert = BACKGROUNDS.stream()
                .filter(n -> !existing.contains(norm(n)))
                .map(Background::new)
                .toList();

        safeSaveAllBackgrounds(toInsert);
    }

    private void seedClasses() {
        Set<String> existing = classRepository.findAll().stream()
                .map(c -> norm(c.getName()))
                .collect(Collectors.toSet());

        var toInsert = CLASSES.stream()
                .filter(n -> !existing.contains(norm(n)))
                .map(Class::new)
                .toList();

        safeSaveAllClasses(toInsert);
    }

    private void seedSpecies() {
        Set<String> existing = speciesRepository.findAll().stream()
                .map(s -> norm(s.getName()))
                .collect(Collectors.toSet());

        var toInsert = SPECIES.stream()
                .filter(n -> !existing.contains(norm(n)))
                .map(Species::new)
                .toList();

        safeSaveAllSpecies(toInsert);
    }

    private String norm(String s) {
        return s == null ? "" : s.trim().toLowerCase(Locale.ROOT);
    }

    private void safeSaveAllBackgrounds(List<Background> items) {
        if (items.isEmpty()) return;
        try {
            backgroundRepository.saveAll(items);
        } catch (DataIntegrityViolationException ignored) {
        }
    }

    private void safeSaveAllClasses(List<Class> items) {
        if (items.isEmpty()) return;
        try {
            classRepository.saveAll(items);
        } catch (DataIntegrityViolationException ignored) {
        }
    }

    private void safeSaveAllSpecies(List<Species> items) {
        if (items.isEmpty()) return;
        try {
            speciesRepository.saveAll(items);
        } catch (DataIntegrityViolationException ignored) {
        }
    }
}