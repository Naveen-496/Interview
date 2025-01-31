// What’s wrong with this code, and how would you fix it to ensure proper error handling without blocking the loop?

async function processUsers(users) {
  users.forEach(async (user) => {
    const data = await fetchUserData(user.id);
    saveToDB(data);
  });
  console.log("All users processed!");
}

// Issues:

// Unhandled Errors: fetchUserData or saveToDB failures are ignored.
// Premature Logging: All users processed! logs before async operations complete.
// Concurrency: Uncontrolled parallel requests (no throttling).

// fixed code

async function processUsers(users) {
  try {
    // Use map + Promise.all for error handling and completion tracking
    await Promise.all(
      users.map(async (user) => {
        try {
          const data = await fetchUserData(user.id);
          await saveToDB(data);
        } catch (error) {
          console.error(`Failed to process user ${user.id}:`, error);
        }
      })
    );
    console.log("All users processed!");
  } catch (error) {
    console.error("Unexpected error:", error);
  }
}
