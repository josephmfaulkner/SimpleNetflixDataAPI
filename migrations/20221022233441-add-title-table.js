'use strict';

var dbm;
var type;
var seed;

/**
  * We receive the dbmigrate dependency from dbmigrate initially.
  * This enables us to not have to rely on NODE_PATH.
  */
exports.setup = function(options, seedLink) {
  dbm = options.dbmigrate;
  type = dbm.dataType;
  seed = seedLink;
};

//id,title,type,description,release_year,runtime,imdb_score,tmdb_score

exports.up = function(db, callback) {
  db.createTable('title', {
    id: { type: 'string', primaryKey: true },
    title: { type: 'string' },
    type: { type: 'string' },
    description: { type: 'string' },
    release_year: { type: 'int' },
    runtime: { type: 'int' },
  }, callback);
};

exports.down = function (db, callback) {
  db.dropTable('title', callback);
};

exports._meta = {
  "version": 1
};
