import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router";
import './index.css';
import App from './App';
import CreateCharacter from "../pages/create-character.tsx";

const router = createBrowserRouter([
  {
    path: "/",
    Component: App,
      children: [
          {
              path: "/create",
              Component: CreateCharacter
          },
      ]
  },
]);

createRoot(document.getElementById('root')!).render(
  <StrictMode>
      <RouterProvider router={router} />
  </StrictMode>,
)
