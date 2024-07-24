const curso = {
    name  : "cuatrimestre 1",
    descripcion : "estudiante"

}

console.log(curso)
console.log(JSON.stringify (curso))

/*fetch('http://localhost:8686/api/univer/materia',{
    method : "POST",
    body : JSON.stringify (curso),
    headers : {"Content-type" : "application/json"}
})
.then( response => {
    console.log(response)
    if(response.ok && response.status === 201){
        console.log('dentro de la primer promesa')
        return response.json()
    }else{
        throw Error(response.statusText) 
    }
})
.then(json =>{
    console.log('segunda promesa')
    console.log(json)
    return json;
})
.catch(error => console.log (error))*/