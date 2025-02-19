import express, { type Request, Response } from "express";

const app = express();

app.get("/", async (req: Request, res: Response) => {
  res.json({ message: "Success" });
  return;
});

app.listen(8000, () => console.log("app started"));
