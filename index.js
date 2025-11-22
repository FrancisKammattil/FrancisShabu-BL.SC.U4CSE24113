const formE1 = document.querySelector(".form");
const inputE1 = document.querySelector(".input");
const u1E1 = document.querySelector(".list");

let list = JSON.parse(localStorage.getItem("list")) || [];

// Load saved tasks
list.forEach(task => {
    ToDoList(task);
});

formE1.addEventListener("submit", (event) => {
    event.preventDefault();
    ToDoList();
});

function ToDoList(task) {
    let newTask = inputE1.value;
    if (task) {
        newTask = task.name;
    }

    const liE1 = document.createElement("li");

    if (task && task.checked) {
        liE1.classList.add("checked");
    }

    liE1.innerText = newTask;
    u1E1.appendChild(liE1);
    inputE1.value = "";

    // CHECK BUTTON
    const checkbtnE1 = document.createElement("div");
    checkbtnE1.innerHTML = '<i class="fas fa-check-square"></i>';
    liE1.appendChild(checkbtnE1);

    // TRASH BUTTON
    const trashBtnEl = document.createElement("div");
    trashBtnEl.innerHTML = '<i class="fa-solid fa-trash"></i>';
    liE1.appendChild(trashBtnEl);

    checkbtnE1.addEventListener("click", () => {
        liE1.classList.toggle("checked");
        updateLocalStorage();
    });

    trashBtnEl.addEventListener("click", () => {
        liE1.remove();
        updateLocalStorage();
    });

    updateLocalStorage();
}

function updateLocalStorage() {
    const liEls = document.querySelectorAll("li");
    list = [];

    liEls.forEach(li => {
        // Remove icon text from name by using .childNodes[0]
        list.push({
            name: li.childNodes[0].textContent.trim(),
            checked: li.classList.contains("checked")
        });
    });

    localStorage.setItem("list", JSON.stringify(list));
}
