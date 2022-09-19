
function Form(){

    

    return (
        
        <form action="">
            <input type="text" placeholder="Nome" className="form-control"/>
            <input type="text" placeholder="Marca" className="form-control"/>

            <input type='button' value='cadastrar' className="btn btn-primary"/>
            <input type='button' value='alterar' className="btn btn-warning"/>
            <input type='button' value='remover' className="btn btn-danger"/>
            <input type='button' value='cancelar' className="btn btn-secondary"/>
        </form>
        )
}
export default Form;