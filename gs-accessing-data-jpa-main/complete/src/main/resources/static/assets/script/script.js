console.log("JS06 - Formulario");
const protocol = window.location.protocol;
const host = window.location.host;
const pathname = window.location.pathname;
const search = window.location.search;
const hash = window.location.hash;
console.log(protocol);
console.log(host);
console.log(pathname);
console.log(search);
console.log(hash);
const urlServer= `${protocol}//${host}`;

// Obtenemos la referencia del formulario
const registerForm = document.forms["registerForm"];

registerForm.addEventListener("submit", async (event) => {
  event.preventDefault();

  const user = {
    email: registerForm.elements["email"].value,
    password: registerForm.elements["password"].value,
  };

  await postUser(user);
});

const postUser = async (userData) => {
  const url = `${urlServer}/login`;
  console.log(userData, url);
  const response = await fetch(url, {
    method: "POST", // POST, PUT, DELETE, GET
    body: JSON.stringify(userData),
    headers: { "Content-Type": "application/json" },
  });

  for (let [key, value] of response.headers) {
    console.log(`${key} = ${value}`);
  }

  const jwt = await response.json();
  console.log(jwt);
  jwt != null && localStorage.setItem("token", jwt.token);
};

/**
 * No se requiere token para esta solicitud
 */
const getProducts = async () => {
	
  const url = `${urlServer}/api/v1/products`;
  console.log("get to " + url);
  const responseJSON = await fetch(url);
  console.log(responseJSON.status);
  const response = await responseJSON.json();
  console.log(response);
};

/**
 * No se requiere token para esta solicitud
 */
const postProduct = async (productData) => {
  const url = `${urlServer}/api/v1/products`;

  const randomId = getRandomInt(10_000); // para generar email aleatorio
  productData = {
    firstName: `Patricio${randomId}`,
    lastName: "Estrella",
    email: `patricio${randomId}@gmail.com`,
    password: "123",
  };

  const responseJSON = await fetch(url, {
    method: "POST",
    body: JSON.stringify(productData),
    headers: { "Content-Type": "application/json" },
  });
  const response = await responseJSON.json();
  console.log(response);
};

/**
 * Se requiere tener un token
 */
const getCustomers = async () => {
  console.log("Get customers");
  const url = `${urlServer}/api/v1/customers`;
  const token = localStorage.getItem("token");
  try {
    const response = await fetch(url, {
      headers: { Authorization: `Bearer ${token}` },
    });
    console.log(response.status);
    const customers = await response.json();
    console.log(customers);
  } catch (e) {
    console.error(e);
  }
};

/**
 * Se requiere tener un token
 */
const postOrder = async () => {
  const url = `${urlServer}/api/v1/orders`;
  const token = localStorage.getItem("token");
  
  const randomAmount = getRandomInt(10_000); // para generar producto aleatorio
 
  orderData = {
    purchaseDate: "2023-09-04T12:06:31",
    totalAmount: randomAmount,
    customer: { id: 1 },
  };

  const response = await fetch(url, {
    method: "POST",
    body: JSON.stringify(orderData),
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
    },
  });
  const newOrder = await response.json();
  console.log(newOrder);
};

/**
 * Se requiere tener un token
 */
const getOrders = async () => {
  const url = `${urlServer}/api/v1/orders`;
  const token = localStorage.getItem("token");
  const response = await fetch(url, {
    headers: { Authorization: `Bearer ${token}` },
  });
  console.log(response.status);
  const orders = await response.json();
  console.log(orders);
};

function getRandomInt(max) {
  return Math.floor(Math.random() * max);
};

const alertPlaceholder = document.getElementById("liveAlertPlaceholder");
const appendAlert = (message, type) => {
  const wrapper = document.createElement("div");
  wrapper.innerHTML = [
    `<div class="alert alert-${type} alert-dismissible" role="alert">`,
    `   <div>${message}</div>`,
    '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
    "</div>",
  ].join("");

  alertPlaceholder.append(wrapper);
};
