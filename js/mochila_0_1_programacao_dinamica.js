//consorcio_tela_principal.do

// JavaScript code for Dynamic Programming based
// solution for 0-1 Knapsack problem  
 
// A utility function that returns
// maximum of two integers
function max(a,b)
{
    return (a > b) ? a : b;
}
    
var choosed_price_list = []  
// Prints the items which are put
// in a knapsack of capacity W
function printknapSack(W,wt,val,n)
{
    let i, w;
    let total = 0;
    let K = new Array(n + 1);
    for( i=0;i<K.length;i++)
    {
        K[i]=new Array(W+1);
        for(let j=0;j<W+1;j++)
        {
            K[i][j]=0;
        }
    }

    // Build table K[][] in bottom up manner
    for (i = 0; i <= n; i++) {
        for (w = 0; w <= W; w++) {
            if (i == 0 || w == 0)
                K[i][w] = 0;
            else if (wt[i - 1] <= w)
                K[i][w] = Math.max(val[i - 1] +
                    K[i - 1][w - wt[i - 1]],
                    K[i - 1][w]);
            else
                K[i][w] = K[i - 1][w];
        }
    }

    // stores the result of Knapsack
    let res = K[n][W];
    console.log(res);

    w = W;
    for (i = n; i > 0 && res > 0; i--)
    {

        // either the result comes from the top
        // (K[i-1][w]) or from (val[i-1] + K[i-1]
        // [w-wt[i-1]]) as in Knapsack table. If
        // it comes from the latter one/ it means
        // the item is included.
        if (res == K[i - 1][w])
            continue;
        else {
            total = total + wt[i - 1]
            // This item is included.
            //console.log(wt[i - 1] + " ");
            choosed_price_list.push(i - 1);

            // Since this weight is included its
            // value is deducted
            res = res - val[i - 1];
            w = w - wt[i - 1];
        }
    }

    console.log('used: ' + total);
}


var book = function () {
    this.name = '';
    this.price = 0;
    this.id = 0;
}

var book_list = []
var wt = []; // prices
//var val = new Array(prices.length).fill(1);
var val = [];

var names = document.querySelectorAll('.a-row .a-size-base .a-link-normal');
console.log(names.length);
var prices = document.getElementsByClassName('a-price-whole');
//var rating = document.getElementsByClassName('a-link-normal g-visible-js reviewStarsPopoverLink');
//var buttons = document.getElementsByClassName('a-button a-button-normal a-button-primary a-button-text a-text-center');

for (var i = 0; i < names.length; i++) {
    try{
        var text_value = prices.item(i).textContent.replaceAll(',','');
        text_value = text_value.replaceAll('.','');
        var item_price = parseInt(text_value)+1;
    }catch{
        item_price = 9999999;
    }

    var item_name = names[i].getAttribute('title');

    //var star = rating[i].getAttribute('aria-label');
    //star = parseInt(star.split(' ')[0]);
    //val.push(star)
    val.push(1)
    //console.log(text_value);

    book_list.push({item_name, item_price, i});
    wt.push(item_price);
}

var  W = 160;
var n = val.length;
printknapSack(W, wt, val, n);

console.log(choosed_price_list);

for (var i = 0; i < choosed_price_list.length; i++) {
    console.log(book_list[choosed_price_list[i]].item_name);
}

/*
for (var i = 0; i < choosed_price_list.length; i++) {
    for (var j = 0; j < book_list.length; j++) {
        if(book_list[j].id == choosed_price_list[i]){
            console.log(book_list[j].item_name);
            names[i].style.color = 'red';
            continue;
        }
        
    }
}
*/

for (var i = 0; i < choosed_price_list.length; i++) {
    names[choosed_price_list[i]].style.color = 'red';
    //buttons[i].click();
}

console.log(names.length);
//console.log(buttons.length);

