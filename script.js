const API = "http://localhost:6969/livros";

document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("form-livro");
  if (!form) {
    console.error("Form #form-livro não encontrado.");
    return;
  }
    form.addEventListener("submit", async (event) => {
    event.preventDefault();

    const formData = new FormData(form);
    const livro = {
      titulo: formData.get("titulo"),
      autor: formData.get("autor"),
      editora: formData.get("editora"),
      anoPublicacao: Number(formData.get("anoPublicacao")),
    };

    try {
      const response = await fetch(API, {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(livro)
      });

      if (!response.ok) {
        throw new Error("Erro ao cadastrar livro");
      }

      form.reset();
      await carregarTabela();
    } catch (error) {
      console.error("Erro:", error);
      alert("Erro ao cadastrar livro. veja o console.");
    }
  });
  carregarTabela();
});

async function carregarTabela() {
    const resp = await fetch(API);
    const dados = await resp.json();
    const tbody = document.querySelector("#tabela tbody");
    tbody.innerHTML = "";
    dados.forEach((f) => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
        <td>${f.id ?? ""}</td>
        <td>${f.titulo ?? ""}</td>
        <td>${f.autor ?? ""}</td>
        <td>${f.editora ?? ""}</td>
        <td>${f.anoPublicacao ?? ""}</td>
        `;
    tbody.appendChild(tr);
  });
}