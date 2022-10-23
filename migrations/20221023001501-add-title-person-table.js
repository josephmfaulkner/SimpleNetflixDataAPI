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

exports.up = function(db, callback) {
  db.createTable('title_person', {
    id: { 
      type: 'int', 
      primaryKey: true, 
      unsigned: true, 
      notNull: true, 
      autoIncrement: true 
    },
    title_id: { 
      type: 'string', 
      notNull: true,
      foreignKey: {
        name: 'title_person_title_id_fk',
        table: 'title',
        rules: {
          onDelete: 'CASCADE',
          onUpdate: 'RESTRICT'
        },
        mapping: 'id'
      }
    },
    person_id: { 
      type: 'int',
      notNull: true,
      foreignKey: {
        name: 'title_person_person_id_fk',
        table: 'person',
        rules: {
          onDelete: 'CASCADE',
          onUpdate: 'RESTRICT'
        },
        mapping: 'id'
      } 
    },
    character : { type: 'string' }, 
    role : { type: 'string' }
  }, callback);
};

exports.down = function (db, callback) {
  db.dropTable('title_person', callback);
};

exports._meta = {
  "version": 1
};
