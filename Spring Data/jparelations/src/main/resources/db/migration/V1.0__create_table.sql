CREATE TABLE job (
	job_id BIGSERIAL PRIMARY KEY,
	title VARCHAR(50),
	salary DECIMAL
);

create table geo_location (
	geo_id BIGSERIAL PRIMARY KEY,
	longitude DECIMAL,
	latitude DECIMAL
);

create table address (
	address_id BIGSERIAL PRIMARY KEY,
	country VARCHAR(50),
	city VARCHAR(50),
	room_number INT,
	geo_location_id BIGINT,
	FOREIGN KEY (geo_location_id) REFERENCES geo_location(geo_id)
);

create table user (
	user_id BIGSERIAL PRIMARY KEY,
	username VARCHAR(50),
	password VARCHAR(50),
	full_name VARCHAR(50),
	job_id BIGINT,
	FOREIGN KEY (job_id) REFERENCES job(job_id)
);

create table user_address (
	id BIGSERIAL PRIMARY KEY,
	user_address_id BIGINT,
	user_user_id BIGINT,
	FOREIGN KEY (user_address_id) REFERENCES address(address_id),
	FOREIGN KEY (user_user_id) REFERENCES user(user_id)
);


