const cheerio=require('cheerio');
const request=require('request');

const url='https://www.espncricinfo.com/series/ipl-2020-21-1210595/chennai-super-kings-vs-kings-xi-punjab-53rd-match-1216506/ball-by-ball-commentary';


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
    let lbcArr=selectorTool('.match-comment-wrapper .match-comment-long-text');
    let lbc=selectorTool(lbcArr[0]).text();
    console.log(lbc);
}





