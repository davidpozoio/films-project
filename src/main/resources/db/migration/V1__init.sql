CREATE TABLE IF NOT EXISTS film(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(200) NOT NULL,
    director VARCHAR(200) NOT NULL,
    minutes INT NOT NULL
);

CREATE TABLE IF NOT EXISTS scene(
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    minutes INT NOT NULL,
    film_id SERIAL NOT NULL,
    budget NUMERIC,
    FOREIGN KEY (film_id) REFERENCES film(id)
);

CREATE TABLE IF NOT EXISTS character(
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    scene_id SERIAL NOT NULL,
    budget NUMERIC,
    FOREIGN KEY (scene_id) REFERENCES scene(id)
);