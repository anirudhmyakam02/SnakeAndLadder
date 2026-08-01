import GridComponent from "../GridComponent/GridComponent"

function BoardComponent(){


    const gameBoard = []
    let gridCount = 1;

    for(let i=0;i<10;i++){
        let row = []
        for(let j=0;j<10;j++){
            row.push(<td>< GridComponent/></td>);
        }
        gameBoard.push(<tr>{row}</tr>);
    }


    return (
        <div>
            {gameBoard}
        </div>
    )
}

export default BoardComponent;