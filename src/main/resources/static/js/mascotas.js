
document.addEventListener("DOMContentLoaded", function () {
  document.getElementById('toggleSidebar').addEventListener('click', function () {
      document.getElementById('sidebar').classList.toggle('collapsed');
      document.getElementById('content').classList.toggle('collapsed');
  });
  const cells = document.querySelectorAll("table tbody td");
  cells.forEach((cell) => {
    if (
      !cell.querySelector("img") &&
      (cell.textContent.trim() === "" ||
        cell.textContent.trim().toLowerCase() === "null")
    ) {
      cell.textContent = "N/A";
    }
  });

  const estadoCells = document.querySelectorAll(
    "table tbody td:nth-child(6)"
  );
  estadoCells.forEach((cell) => {
    const text = cell.textContent.trim();
    cell.innerHTML = `<span>${text}</span>`;
    const span = cell.querySelector("span");
    if (text === "En tratamiento") {
      span.style.backgroundColor = "#B3261E";
      span.style.color = "#ffffff";
      span.style.padding = "1px 4px";
      span.style.borderRadius = "10px";
    } else {
      span.style.backgroundColor = "#f0f2f5";
      span.style.padding = "1px 4px";
      span.style.borderRadius = "10px";
    }
  });
});


