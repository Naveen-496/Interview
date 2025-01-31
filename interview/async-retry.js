async function retryRequest(url, maxRetires = 3, delayMs = 1000) {
  for (let i = 1; i <= maxRetires; i++) {
    try {
      const response = await fetch(url);
      if (!response.ok) throw new Error(`Http Error: ${response.statusText}`);
      return response;
    } catch (error) {
      if (i === maxRetires) throw error;
      await new Promise((resolve) => setTimeout(resolve, delayMs));
    }
  }
}

retryRequest("https://www.google.com")
  .then((response) => console.log(response))
  .catch((err) => console.log(err.message));
