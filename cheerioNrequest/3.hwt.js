const cheerio=require('cheerio');
const request=require('request');
const fs=require('fs');

const url="https://www.espncricinfo.com/series/ipl-2020-21-1210595/delhi-capitals-vs-mumbai-indians-final-1237181/full-scorecard";


request(url,cb);
function cb(err, res, html){
    if(err){
        console.log(err);
    }
    else{
        extractHtml(html);
    }
}

function extractHtml(html){
    let selectorTool= cheerio.load(html);
    let bowlerTableArr=selectorTool('.card.content-block.match-scorecard-table .Collapsible__contentOuter .table.bowler');
    console.log(bowlerTableArr.length);
    let hwtn="";
    let hwtw=0;
    for(let i=0;i<bowlerTableArr.length;i++){
        let bowlerTable=selectorTool(bowlerTableArr[i]);
        let allBowlers=selectorTool(bowlerTable).find('tbody tr');
        for(let j=0;j<allBowlers.length;j++){
            let colOfEachPlayerArr=selectorTool(allBowlers[j]).find('td');
            // console.log(colOfEachPlayerArr.length);
            if(colOfEachPlayerArr.length!=1){
            
            let a=selectorTool(colOfEachPlayerArr[0]).text();
            let b=selectorTool(colOfEachPlayerArr[4]).text();
            // console.log(a);
                if(b>hwtw){
                    hwtw=b;
                    hwtn=a;
                }
            }
        }
        
    }
    console.log(hwtn,hwtw);
}





