const senhaInput = document.querySelector("#senha")
const confirmaSenha = document.querySelector("#confirmarSenha")

senhaInput.addEventListener("keyup", () => {
  const senha = senhaInput.value;
  let isValid = senha.length >= 4 && senha.length <= 24 && /[0-9]/.test(senha) && /[a-z]/.test(senha) && /[A-Z]/.test(senha);
  if (isValid) {
    senhaInput.classList.remove("is-invalid")
    senhaInput.classList.add("is-valid")
  } else {
    senhaInput.classList.remove("is-valid")
    senhaInput.classList.add("is-invalid")
  }
})

confirmaSenha.addEventListener("keyup", () => {
  if (confirmaSenha.value === senhaInput.value) {
    confirmaSenha.classList.remove("is-invalid")
    confirmaSenha.classList.add("is-valid")
  } else {
    confirmaSenha.classList.remove("is-valid")
    confirmaSenha.classList.add("is-invalid")
  }
})

