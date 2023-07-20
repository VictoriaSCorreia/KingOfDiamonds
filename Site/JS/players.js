let element = document.getElementById('icon');
let newElement = document.getElementById('icon2');

function hideElement() {
    element.style.display = 'none';
    newElement.style.display = 'block';
}
function showElement(){
    element.style.display = 'block';
    newElement.style.display = 'none';
}
function changeContent() {
    var divisa = document.querySelector('#divisa');
    divisa.style.backgroundColor = 'rgb(252, 11, 11)';
    divisa.style.boxShadow = '0px 0px 5px 2px rgb(230, 0, 0)';
}