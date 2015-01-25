cursor = db.students.aggregate( 
  [ { "$unwind": "$scores" },  
    {"$match": {"scores.type": "homework"}},
	{"$group": { '_id':'$_id' , 'minitem': {'$min': "$scores.score" }}}
	
  ] );
 
cursor.forEach(
  function(student) {
	  db.students.update({'_id' : student._id},{'$pull': {'scores': {'score': student.minitem}}} )
  }
)
