// SEARCH INPUT --------------
const searchInput = document.getElementById("searchInput");
const tableRows = document.querySelectorAll("table tbody tr");

searchInput.addEventListener("input", function () {
    const searchText = searchInput.value.toLowerCase();

    tableRows.forEach((row) => {
        const cellText = row.querySelector("td:first-child").textContent.toLowerCase();

        if (cellText.includes(searchText)) {
            row.style.display = "";  // Mostrar la fila
        } else {
            row.style.display = "none";  // Ocultar la fila
        }
    });
});
// ----------------------------