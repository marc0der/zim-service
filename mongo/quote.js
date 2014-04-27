//ensure that you have mongod running
//load this data using the following command line `mongo invasion quote.js`
db.quote.drop();
db.quote.insert({_id:1, name:"zim", message:"INSOLENT SCHOOLBOY! It's a skin condition." });
db.quote.insert({_id:2, name:"gir", message:"Can I be a mongoose?" });
