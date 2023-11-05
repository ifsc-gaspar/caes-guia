document.addEventListener("DOMContentLoaded", () => {
  carregarBuscadorCep();
});

carregarBuscadorCep = () => {
  const cep = document.getElementById("cep");
  cep.addEventListener("blur", (event) => buscarCep(event.target.value));
}

buscarCep = (cep) => {
  if (!cep) {
    return;
  }

  const baseUrl = window.location.origin;

  $.ajax({
    url: `${baseUrl}/endereco?cep=${cep}`,
    type: "GET",
    success: (response) => {
      document.getElementById("estado").value = response.estado;
      document.getElementById("cidade").value = response.cidade;
      document.getElementById("logradouro").value = `${response.logradouro}, ${response.bairro}`;
      document.getElementById("endereco-numero").value = response.numero;
    },
    error: (error) => {
      console.log("Erro ao buscar o cep");
    }
  });
}
