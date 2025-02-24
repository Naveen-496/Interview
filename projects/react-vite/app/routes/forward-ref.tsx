

// forwardRef is a function that lets a parent component to access the dom nodes of a child component

// forwardRef takes render function as an argument. This render function receives props and ref passed to the component that can be passed down to child components

import { forwardRef, useEffect, useRef } from "react";



export default function ParentComponent() {
  const inputRef = useRef<HTMLInputElement | null>(null);

  useEffect(() => {
    if (inputRef) {
      inputRef.current?.focus();
    }
  }, []);

  return <InputChild ref={inputRef} />;
}

const InputChild = forwardRef<HTMLInputElement | null>((props, ref) => {
  return <input type="text" ref={ref} />;
});
