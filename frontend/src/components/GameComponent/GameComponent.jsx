import { useEffect, useRef, useState } from "react";
import GridComponent from "../GridComponent/GridComponent";

function GameComponent(){

    const [ gameState, setGameState ] = useState(null);

    const [ grids, setGrids] = useState([]);

    useEffect(()=>{
        generateGameGrids()
    },[])

    useEffect(() => {
        // console.log("Updated grids:", grids);
      }, [grids]);

    function generateGameGrids(){

        let tempGrids = []

        let gridNo = 100
        for (let i = 10; i >= 1; i--) {
            let row = []
            for (let j = 10; j >= 1; j--){

                let gridData = {
                    gridNo:gridNo,
                    updatedPlayersInGrid: []
                }
    
                row.push(
                  <GridComponent key={gridNo} data = {gridData} />
                );

                gridNo--;
            }
            if(i%2 != 0){
                row.reverse();
            }

            tempGrids.push(row)
            // console.log(tempGrids)
        }

        setGrids(tempGrids)

    }


    return (
        <>
            { grids?.map((row, rowIndex) => (
              <div key={rowIndex}>
                {row}
              </div>
            ))}
        </>
    )
}

export default GameComponent;