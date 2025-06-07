// Online Javascript Editor for free
// Write, Edit and Run your Javascript code using JS Online Compiler

console.log("Welcome to Programiz!");
const dictArray = ['cat', 'car', 'bat'];

const dictionary = (wordStore) => {
    return wordStore.reduce((acc, word) => {
        acc[word] = true;
        word.split('').forEach((letter, i) => {
            let start = word.substr(0,i);
            let end = word.substr(i+1);
            acc[`${start}*${end}`] = true;
        })
        return acc;
    }, {});
}

const isInDict = (word) => {
    const regEx = new RegExp(`^${word.replaceAll('*','.')}$`);
    return dictArray.some((dictWord) => {
        return regEx.test(dictWord);
    });
    
   // return !!dictionary(dictArray)[word];
}

console.log(isInDict('car'))
console.log(isInDict('bar'))
console.log(isInDict('*ar'))
console.log(isInDict('*at'))
console.log(isInDict('***'))

console.log(dictionary(dictArray))