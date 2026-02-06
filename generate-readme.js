const fs = require("fs");
const path = require("path");

// Load stats.json
const statsPath = path.join(__dirname, "stats.json");
const stats = JSON.parse(fs.readFileSync(statsPath, "utf-8"));

const leetcode = stats.leetcode;

// Basic stats
const easy = leetcode.easy;
const medium = leetcode.medium;
const hard = leetcode.hard;
const total = leetcode.solved;

// Group problems by difficulty
const problemsByDifficulty = {
  easy: [],
  medium: [],
  hard: [],
};

Object.entries(leetcode.shas).forEach(([key, value]) => {
  if (value.difficulty && key !== "README.md" && key !== "stats.json") {
    problemsByDifficulty[value.difficulty].push(key);
  }
});

// Sort problems numerically
Object.keys(problemsByDifficulty).forEach(diff => {
  problemsByDifficulty[diff].sort(
    (a, b) => parseInt(a.split("-")[0]) - parseInt(b.split("-")[0])
  );
});

// Generate README content
const readmeContent = `
# 🚀 LeetCode Practice Codes

A collection of **LeetCode problems solved in Java**, automatically tracked using **LeetHub v2**.

---

## 📊 Progress Overview

| Difficulty | Solved |
|-----------|--------|
| 🟢 Easy   | ${easy} |
| 🟡 Medium | ${medium} |
| 🔴 Hard   | ${hard} |
| **Total** | **${total}** |

---

## 🟢 Easy Problems (${easy})
${problemsByDifficulty.easy
  .map(
    p =>
      `- [${p}](https://github.com/darklegend91/LeetCode-Practice-Codes/tree/master/${p})`
  )
  .join("\n")}

---

## 🟡 Medium Problems (${medium})
${problemsByDifficulty.medium
  .map(
    p =>
      `- [${p}](https://github.com/darklegend91/LeetCode-Practice-Codes/tree/master/${p})`
  )
  .join("\n")}

---

## 🔴 Hard Problems (${hard})
${
  problemsByDifficulty.hard.length === 0
    ? "_No hard problems solved yet._"
    : problemsByDifficulty.hard
        .map(
          p =>
            `- [${p}](https://github.com/darklegend91/LeetCode-Practice-Codes/tree/master/${p})`
        )
        .join("\n")
}

---

## ⚙️ Automation
- 📊 Stats powered by \`stats.json\`
- 🔄 README auto-generated
- 🚀 Compatible with LeetHub v2

---

## 🧑‍💻 Language
- Java

---

⭐ Keep practicing. Keep improving.
`.trim();

// Write README.md
fs.writeFileSync("README.md", readmeContent, "utf-8");

console.log("✅ README.md generated successfully!");
