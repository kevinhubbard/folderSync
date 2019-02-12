const fs = require('fs');
const inputDir = process.argv[2];
let outputDir = process.argv[3];

let folderA = new Array;
let folderB = new Array;

folderA = fs.readdirSync(inputDir);
folderB = fs.readdirSync(outputDir);

console.log('\n folderA contents:');
console.log(folderA);
console.log('\n folderB contents:');
console.log(folderB);

for(i=0; i<folderA.length; i++){
	if(folderB.includes(folderA[i])){
		console.log(folderA[i] + ' is already in folderB!');
	} else {
		console.log(folderA[i] + ' was not in folderB.');
		folderB.push(folderA[i]);
		fs.copyFileSync(inputDir + folderA[i], outputDir + folderA[i]);
	}
}

console.log('\n folderB updated contents:' );
console.log(folderB);