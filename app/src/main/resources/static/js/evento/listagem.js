document.addEventListener("DOMContentLoaded", () => {
    listagemEventos.functions.pagination.carregarListagemEventosPaginada();
});

var listagemEventos = {
    elements: {
        alert: () => {
            return document.querySelector("#listagem-eventos-container div[role=alert]");
        }
    },
    functions: {
        alert: {
            show: (message, type) => {
                let alert = listagemEventos.elements.alert();
                alert.innerHTML = `<div class="alert ${type}" role="alert">${message}</div>`;
                alert.hidden = false;
            },
            hide: () => {
                let alert = listagemEventos.elements.alert();
                alert.hidden = true;
            }
        },
        eventos: {
            construirLinhas: (eventos) => {
                let linhas = ``;

                eventos.forEach(evento => linhas += listagemEventos.functions.eventos.construirLinha(evento));

                return linhas;
            },
          construirLinha: (evento) => {
            const { dia, mes, ano } = listagemEventos.functions.eventos.formatarData(evento.data);

            const categoriasLegendas = {
              "1": "Vacina",
              "2": "Treinamento",
              "3": "Socializacao",
              "4": "Veterinário",
              "5": "Banho",
              "6": "Outros"
            };

            const categoriaLabel = categoriasLegendas[evento.categoria];

            return `
              <div class="d-flex border border-secondary-subtle rounded-2 mb-3">
                  <div>
                      <div class="p-4">
                          <p class="mb-1 text-muted" style="font-size: 0.875rem;">${ano}</p>
                          <strong>
                              <p class="mb-0" style="font-weight: 800;">${dia}/${mes}</p>
                          </strong>
                      </div>
                  </div>
                  <div class="p-3">
                      <h5>${evento.titulo}</h5>
                      <p>${evento.descricao}</p>
                      <p>${categoriaLabel}</p> <!-- Usa o rótulo da categoria aqui -->
                      <a class="icon-link icon-link-hover" href="${urlEvento}/visualizar" style="--bs-icon-link-transform: translate3d(0, -.125rem, 0);">
                          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                              <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                              <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                          </svg>
                      </a>
                  </div>
              </div>
            `
            },
            formatarData(data) {
                let date = new Date(data);

                let dia = date.getDate().toString().padStart(2, '0');
                let mes = new Intl.DateTimeFormat('pt-BR', { month: 'long' }).format(date);
                mes = mes.charAt(0).toLocaleUpperCase() + mes.slice(1);
                let ano = date.getFullYear();

                return {
                    dia,
                    mes,
                    ano
                }
            },
            nomeDaCategoria(valor) {
              switch (valor) {
                case 1:
                  return "Vacina";
                case 2:
                  return "Treinamento";
                case 3:
                  return "Socializacao";
                case 4:
                  return "Veterinário";
                case 5:
                  return "Banho";
                case 6:
                  return "Outros";
              }
            },
        },
        pagination: {
            carregarListagemEventosPaginada: () => {
                const baseUrl = document.getElementById("base-url").value;
                const idCao = document.getElementById("id-cao").value;

                // Documentação: https://pagination.js.org
                $('#listagem-eventos-container')
                    .pagination({
                        dataSource: `${baseUrl}/rest/caes/${idCao}/eventos`,
                        pageSize: 10,
                        locator: "content",
                        ajax: {
                            pageNumberStartWithZero: true
                        },
                        alias: {
                            pageNumber: "page",
                            pageSize: "size"
                        },
                        totalNumberLocator: (response) => response.totalElements,
                        formatAjaxError: (jqXHR, textStatus, errorThrown) => listagemEventos.functions.pagination.onError(jqXHR, textStatus, errorThrown),
                        callback: (data, pagination) => listagemEventos.functions.pagination.onSuccess(data, pagination)
                    });
            },
            onError: (jqXHR, textStatus, errorThrown) => {
                console.log("formatAjaxError", jqXHR, textStatus, errorThrown);

                //TODO: Testar o error!!

                let message = "Falha ao carregar os eventos";
                listagemEventos.functions.alert.show(message, alertType.danger);
            },
            onSuccess: (data, pagination) => {
                if (!data.length) {
                    let message = "Nenhum evento cadastrado";
                    listagemEventos.functions.alert.show(message, alertType.primary);

                    return;
                }

                listagemEventos.functions.alert.hide(); //TODO: Não da pra remover?

                var linhas = listagemEventos.functions.eventos.construirLinhas(data);
                $("#eventos-container").html(linhas);
            }
        }
    },
}

const alertType = {
    primary: "alert-primary",
    danger: "alert-danger"
}
