//CARROUSEL
const carousel = document.querySelector('.carousel');
const slides = document.querySelectorAll('.slide');
let currentSlide = 0;

function showSlide(n) {
    currentSlide = (n + slides.length) % slides.length;
    carousel.style.transform = `translateX(-${currentSlide * 100}%)`;
}

function nextSlide() {
    showSlide(currentSlide + 1);
}
setInterval(nextSlide, 5000);


//Recargar al darle click en el logo
const logo = document.querySelector('.logo-landing');
logo.addEventListener('click', () => {
    location.reload();
});