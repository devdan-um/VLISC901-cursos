const curso ={
    nombre: "Algebra",
    descripcion: "Algebra Lineal"
}

fetch('http://localhost:8686/api/univer/materias/1',{
    method: "GET",
   // body: JSON.stringify(curso),
    headers: {"content-type":"applicatio/json"}
})

.then(response =>{
    console.log(response)
    if(response.ok && response.status === 200){
        console.log('dentro de la primera promesa')
        return response.json()
    }else{
        throw Error (response.statusText)
    }
})
.then(json=>{
    console.log('segunda promesa ')
    console.log(json)
    return json;
})
.catch(error=>console.log(error))