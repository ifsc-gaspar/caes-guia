document.addEventListener("DOMContentLoaded", () => {
    listagemVacinas.functions.pagination.carregarListagemVacinasPaginada();
});

var listagemVacinas = {
    elements: {
        alert: () => {
            return document.querySelector("#listagem-vacinas-container div[role=alert]");
        },
        table: () => {
            return document.querySelector("#listagem-vacinas-container table");
        }
    },
    functions: {
        alert: {
            show: (message, type) => {
                let alert = listagemVacinas.elements.alert();
                alert.innerHTML = `<div class="alert ${type}" role="alert">${message}</div>`;
                alert.hidden = false;
            },
            hide: () => {
                let alert = listagemVacinas.elements.alert();
                alert.hidden = true;
            }
        },
        table: {
            show: () => {
                let table = listagemVacinas.elements.table();
                table.hidden = false;
            },
            hide: () => {
                let table = listagemVacinas.elements.table();
                table.hidden = true;
            },
            construirLinhas: (vacinas) => {
                let linhasTabela = '';

                vacinas.forEach(vacina => {
                    linhasTabela += listagemVacinas.functions.table.construirLinha(vacina);
                });

                return linhasTabela;
            },
            construirLinha: (vacina) => {
                const baseUrl = document.getElementById("base-url").value;

                const urlVacina = `${baseUrl}/vacinas/${vacina.id}`;

                return `
                    <tr id="vacina-item-${vacina.id}">
                        <td>${vacina.nomeVacina}</td>
                        <td>${vacina.tipoVacina}</td>
                        <td>${vacina.numerodeDose}</td>
                        <td>${vacina.periodoAdministracao}</td>
                        <td>${vacina.observacoes}</td>
                        <td>${vacina.faixaEtaria}</td>
                        <td>${vacina.obrigatoriedade ? 'Sim' : 'Não'}</td>
                        <td>${vacina.acompanhamentoVeterinario ? 'Sim' : 'Não'}</td>
                        <td>${vacina.periodoDeVermifugacao}</td>
                        <td class="text-center">
                            <a class="icon-link icon-link-hover" href="${urlVacina}/visualizar" style="--bs-icon-link-transform: translate3d(0, -.125rem, 0);">
                                <!-- ícone de olho -->
                            </a>
                            <a class="icon-link icon-link-hover ms-3" href="${urlVacina}/editar" style="--bs-icon-link-transform: translate3d(0, -.125rem, 0);">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                                                    <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502 .646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121 .196l-.805 2.414a.25.25 0 0 0 .316 .316l 2.414-.805a.5.5 0 0 0 .196-.12l 6.813-6.814z"/>
                                                                    <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                                                                </svg>
                            </a>
                            <a
                                class="icon-link icon-link-hover ms-3"
                                href="${urlVacina}/excluir"
                                style="--bs-icon-link-transform: translate3d(0, -.125rem, 0);"
                                data-bs-toggle="modal"
                                data-bs-target="#basicModal"
                                data-bs-modal-header="Excluir vacina"
                                data-bs-modal-body="Tem certeza que deseja excluir esta vacina?"
                                data-bs-modal-footer-text-cancel="Cancelar"
                                data-bs-modal-footer-text-confirm="Excluir"
                            >
                               <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                                                   <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
                                                                   <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
                                                               </svg>
                            </a>
                        </td>
                    </tr>
                `;
            }
        },
        pagination: {
            carregarListagemVacinasPaginada: () => {
                const baseUrl = document.getElementById("base-url").value;

                // Documentação: https://pagination.js.org
                $('#listagem-vacinas-container tfoot').pagination({
                    dataSource: `${baseUrl}/rest/vacinas`,
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
                    formatAjaxError: (jqXHR, textStatus, errorThrown) => listagemVacinas.functions.pagination.onError(jqXHR, textStatus, errorThrown),
                    callback: (data, pagination) => listagemVacinas.functions.pagination.onSuccess(data, pagination)
                });
            },
            onError: (jqXHR, textStatus, errorThrown) => {
                console.log("formatAjaxError", jqXHR, textStatus, errorThrown);

                listagemVacinas.functions.table.hide();

                let message = "Falha ao carregar a listagem de vacinas";
                listagemVacinas.functions.alert.show(message, alertType.danger);
            },
            onSuccess: (data, pagination) => {
                if (!data.length) {
                    listagemVacinas.functions.table.hide();

                    let message = "Nenhuma vacina cadastrada";
                    listagemVacinas.functions.alert.show(message, alertType.primary);

                    return;
                }

                listagemVacinas.functions.alert.hide();

                var linhasTabela = listagemVacinas.functions.table.construirLinhas(data);
                $("#listagem-vacinas-container tbody").html(linhasTabela);

                listagemVacinas.functions.table.show();
            }
        }
    }
};

const alertType = {
    primary: "alert-primary",
    danger: "alert-danger"
};
