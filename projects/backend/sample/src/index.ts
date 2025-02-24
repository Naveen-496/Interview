import express, { type Request, Response } from "express";

const app = express();
app.use(express.json());

app.get("/", async (req: Request, res: Response) => {
  res.json({ message: "Success" });
  return;
});

app.get("/posts", async (req: Request, res: Response) => {
  
  res
    .json([{ id: 1, title: "How to win friends and influence peopls" }])
    .status(200);
  return;
});

app.listen(8000, () => console.log("app started"));
