document.addEventListener("DOMContentLoaded", function () {
    const cells = document.querySelectorAll("li span");
    cells.forEach(cell => {
      if (!cell.querySelector("img") && (cell.textContent.trim() === "" || cell.textContent.trim().toLowerCase() === "null")) {
        cell.textContent = "N/A";
      }
    });
  });