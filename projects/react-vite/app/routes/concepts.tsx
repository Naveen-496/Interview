/**
 * 1. Components
 * 2. Rendering
 * 3. Context
 * 4. Purity
 * 5. Keys
 * 6. Boundaries
 * 7. Refs
 * 8. Children
 * 9. Refs
 * 10. Effects
 * 11. JSX
 * 12. Hooks
 * 13. Suspense
 * 14. Events
 * 15. Fragments
 * 16. Props
 * 17. State
 * 18. Portal
 * 19. VDOM
 * 
 * 
 * 
 * 
 * 1. Components
        Definition:
        Components are the basic building blocks of a React application. They are independent, reusable pieces of UI that can be either class-based or function-based.

   2. Rendering
        Definition:
        Rendering is the process by which React translates components into DOM elements that the browser can display. The React reconciliation algorithm optimizes updates by re-rendering only what has changed.    

        import ReactDOM from 'react-dom';

        ReactDOM.render(<Greeting name="Alice" />, document.getElementById('root'));

        3. Context
        Definition:
        Context provides a way to pass data through the component tree without having to pass props down manually at every level. It’s ideal for global data like themes or authentication.

        4. Purity
        Definition:
        A pure component is one that, given the same props and state, will always render the same output without causing side effects. Pure components help optimize performance by avoiding unnecessary re-renders.

        5. Keys
        Definition:
        Keys are unique identifiers used by React to track elements in a list. They help the reconciliation process by efficiently updating only the items that have changed.

        6. Boundaries (Error Boundaries)
        Definition:
        Error boundaries are special components that catch JavaScript errors anywhere in their child component tree, log those errors, and display a fallback UI instead of crashing the entire app.

        7. Refs
        Definition:
        Refs provide a way to access DOM nodes or React elements directly. They are useful for managing focus, text selection, or integrating with third-party libraries.

        8. Children
        Definition:
        The children prop in React holds the content between the opening and closing tags of a component. This allows components to wrap and render nested elements dynamically.

        9. Refs (Advanced / Forwarding)
        Definition:
        Beyond basic usage, refs can be forwarded using React.forwardRef to allow parent components to directly interact with child components’ DOM nodes.

        10. Effects
        Definition:
        Effects in React (via the useEffect hook) allow you to perform side effects in function components, such as data fetching, subscriptions, or manually updating the DOM.

        11. JSX
        Definition:
        JSX is a syntax extension that allows you to write HTML-like code within JavaScript. It makes the structure of UI components more readable and expressive.

        12. Hooks
        Definition:
        React hooks are JavaScript functions that let you use React features in functional components instead of class components. They were introduced in React 16.8.

        13. Suspense
        Definition:
        Suspense is a React component that lets you display a fallback UI (like a loading spinner) while waiting for some asynchronous code to load. It is often used with React.lazy for code-splitting.

        import React, { Suspense, lazy } from 'react';

        const LazyComponent = lazy(() => import('./LazyComponent'));

        function App() {
        return (
            <Suspense fallback={<div>Loading...</div>}>
            <LazyComponent />
            </Suspense>
        );
        }


        14. Events
        Definition:
        React standardizes events across different browsers with its synthetic event system. Event handlers in React are passed as props and follow camelCase naming.

        React events are synthetic wrapper events around native browser events with consistent cross-browser behavior.

        15. Fragments
        Definition:
        Fragments let you group multiple elements without adding an extra node to the DOM. They’re useful when returning multiple elements from a component.

        16. Props
        Definition:
        Props (short for properties) are inputs to a React component. They allow data to be passed from a parent component to a child component, making components more dynamic and reusable.

        17. State
        Definition:
        State represents data that changes over time within a component. When state updates, React re-renders the component to reflect the changes in the UI.

        18. Portal
        Definition:
        Portals provide a way to render a component’s children into a DOM node that exists outside the DOM hierarchy of the parent component. This is useful for modals, tooltips, and overlays.


        19. VDOM (Virtual DOM)
        Definition:
        The Virtual DOM is an in-memory, lightweight representation of the real DOM. React uses it to efficiently determine what changes need to be made to the actual DOM by performing a diff between the previous and current virtual trees.
        Explanation:
        When a component’s state changes, React updates the Virtual DOM first. It then calculates the minimal set of changes required to update the real DOM, which results in improved performance and a smoother user experience.
 * 
 */
