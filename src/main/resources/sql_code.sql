--Creating tables for database

CREATE TABLE grape_variety (
    variety_id VARCHAR(50) PRIMARY KEY,
    variety_name VARCHAR(50) NOT NULL,
    grape_color VARCHAR(50),
    primary_use VARCHAR(20),
    wine_color VARCHAR(20) NOT NULL,
    variety_origin VARCHAR(150),
    parents VARCHAR(150),
    pseudonym VARCHAR(50),
    harvest_season VARCHAR(50),
    usda_hardiness_zone VARCHAR(50),
    sulfur_sensitivity VARCHAR(50),
    vine_vigor VARCHAR(20),
    growth_habit VARCHAR(20),
    suggested_distance_between_vines VARCHAR(50),
    vine_training_system VARCHAR(50),
    bud_break VARCHAR(50),
    black_rot VARCHAR(50),
    downy_mildew VARCHAR(50),
    powdery_mildew VARCHAR(50),
    botrytis VARCHAR(50)
);

CREATE TABLE harvest (
    harvest_id VARCHAR(50) PRIMARY KEY,
    year INT NOT NULL,
    variety_id VARCHAR(50) NOT NULL,
    variety_name VARCHAR(50),
    location VARCHAR(50),
    harvest_date DATE not null,
    crush_date DATE,
    pounds INT,
    FOREIGN KEY (variety_id) REFERENCES grape_variety(variety_id)
);

CREATE TABLE vinification (
    vinification_id VARCHAR(50) PRIMARY key not NULL,
    harvest_id VARCHAR(50) NOT NULL,
    wine_style VARCHAR(50),
    gallons INT,
    pH_level DECIMAL(4, 2),
    must_temperature INT,
    original_gravity INT,
    brix INT,
    inoculation_date DATE,
    maceration BOOLEAN,
    chaptalization BOOLEAN,
    pounds_sugar_added INT,
    yeast_strand VARCHAR(50),
    malolactic_fermentation BOOLEAN,
    FOREIGN KEY (harvest_id) REFERENCES harvest(harvest_id)
);

CREATE TABLE vinification_blend (
    vinification_id VARCHAR(50) NOT NULL,
    variety_id VARCHAR(50) NOT NULL,
    percentage DECIMAL(5, 2),
    PRIMARY KEY (vinification_id, variety_id),
    FOREIGN KEY (vinification_id) REFERENCES vinification(vinification_id),
    FOREIGN KEY (variety_id) REFERENCES grape_variety(variety_id)
);

CREATE TABLE wine_cellar (
    bottle_id VARCHAR(50) PRIMARY KEY,
    vinification_id VARCHAR(50) NOT NULL,
    bottle_volume INT NOT NULL,
    alcohol_percentage DECIMAL(4, 2),
    FOREIGN KEY (vinification_id) REFERENCES vinification(vinification_id)
);


CREATE TABLE bulk_aging (
    carboy_id VARCHAR(50) PRIMARY KEY, -- Unique identifier for each carboy
    vinification_id VARCHAR(50) NOT NULL, -- Foreign key referencing vinification
    capacity_gallons DECIMAL(5, 2) NOT NULL, -- Capacity of the carboy in liters
    material VARCHAR(50), -- Material of the carboy (e.g., glass, stainless steel)
    FOREIGN KEY (vinification_id) REFERENCES vinification(vinification_id)
);

-- Altering tables and modifying database structure as needed

ALTER TABLE wine_cellar
ADD CONSTRAINT chk_bottle_id_format CHECK (bottle_id REGEXP '^[A-Z]{2}\\d{2}-\\d{4}-\\d{3}$');

show tables like 'wine_cellar';
select * from wine_cellar wc ;

ALTER TABLE grape_variety
DROP COLUMN grape_origin;

DESCRIBE grape_variety;

ALTER TABLE grape_variety
ADD COLUMN year_released INT;

ALTER TABLE wine_cellar DROP FOREIGN KEY wine_cellar_ibfk_1;

ALTER TABLE wine_cellar MODIFY COLUMN vinification_id VARCHAR(50) NOT NULL;

SHOW CREATE TABLE wine_cellar;

ALTER TABLE wine_cellar DROP FOREIGN KEY vinification_id;

describe wine_cellar 

DROP TABLE IF EXISTS wine_cellar;

drop table if exists bulk_aging;

describe grape_variety 

ALTER TABLE grape_variety MODIFY COLUMN year_released VARCHAR(4);

ALTER TABLE grape_variety MODIFY COLUMN year_released VARCHAR(10);

ALTER TABLE harvest DROP COLUMN variety_name;

ALTER TABLE harvest MODIFY COLUMN pounds DOUBLE NULL;

ALTER TABLE harvest MODIFY COLUMN harvest_date DATE NULL;

describe harvest 

-- Correcting data for grape variety Edelweiss

UPDATE grape_variety
SET grape_color = 'White'
WHERE variety_id = '3H9ZVQ';

-- Post-processing data to ensure alcohol percentage is included for blended wines in wine_cellar

UPDATE wine_cellar wc
SET wc.alcohol_percentage = (
    SELECT SUM(vb.percentage / 100 * (v.brix * 0.55 + IFNULL((v.pounds_sugar_added / v.gallons) * 1.0, 0)))
    FROM vinification_blend vb
    JOIN vinification v ON vb.vinification_id = v.vinification_id
    WHERE vb.bottle_id = wc.bottle_id
)
WHERE wc.vinification_id IS NULL;
