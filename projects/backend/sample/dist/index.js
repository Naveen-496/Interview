"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
const app = (0, express_1.default)();
app.use(express_1.default.json());
app.get("/", async (req, res) => {
    res.json({ message: "Success" });
    return;
});
app.get("/posts", async (req, res) => {
    res
        .json([{ id: 1, title: "How to win friends and influence peopls" }])
        .status(200);
    return;
});
app.listen(8000, () => console.log("app started"));
