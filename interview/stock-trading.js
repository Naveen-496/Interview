/**
 * @param {number[]} prices
 * @return {number}
 */

function maxProfit(prices) {
  let maxProfit = 0;
  for (let i = 0; i < prices.length; i++) {
    for (let j = i + 1; j < prices.length; j++) {
      let profit = prices[j] - prices[i];
      maxProfit = Math.max(maxProfit, profit);
    }
  }
  return maxProfit;
}

const prices = [1, 2, 3, 4];
console.log(maxProfit(prices));
