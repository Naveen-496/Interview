import React from "react";

class ErrorBoundry extends React.Component {
  constructor(props: any) {
    super(props);
    this.state = { hasError: false };
  }

  static getDerivedStateFromError() {
    return { hasError: true };
  }

  componentDidCatch(error: Error, errorInfo: React.ErrorInfo): void {
    console.log("Error Caught: ", error, errorInfo);
  }

  render(): React.ReactNode {
    if (this.state.hasError) {
      return <h2>Something went wrong. Please try later.</h2>;
    }
    return this.props.children;
  }
}

function BuggyComponent() {
  throw new Error("Oops!");

  return <h2>This won't render</h2>;
}

export default function CompWithError() {
  return (
    <ErrorBoundry>
      <BuggyComponent />
    </ErrorBoundry>
  );
}
