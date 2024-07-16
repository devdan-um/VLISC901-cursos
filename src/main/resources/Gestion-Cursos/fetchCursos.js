    const curso = {
        nombre: "Matematicas",
        descripcion: "Matematicas discretas"
    }
    fetch('http://localhost:8686/api/univer/materias/1', {
        method: "GET",
        //body: JSON.stringify(curso),
        headers: {"Content-Type": "application/json"}
    })
    .then(response => {
        if(response.ok && response.status===200){
            console.log("Dentro de la primera promesa")
            return response.json()
        }else{
            throw Error(response.statusText)
        }
    })
    .then(json =>{
        console.log("Segunda promesa")
        console.log(json);
        return json;
    })
    .catch(error => {console.log(error)})