--
-- PostgreSQL database dump
--


--SET client_encoding = 'LATIN1';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 6 (class 2615 OID 75663)
-- Name: dml; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA dml;


--
-- TOC entry 2172 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA dml; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON SCHEMA dml IS 'Tabelas do projeto música.';


SET search_path = dml, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1853 (class 1259 OID 75674)
-- Dependencies: 6
-- Name: cantor; Type: TABLE; Schema: dml; Owner: -; Tablespace: 
--

CREATE TABLE cantor (
    cod_cantor integer NOT NULL,
    nome_cantor character varying(50),
    pais character varying(30)
);


--
-- TOC entry 1852 (class 1259 OID 75669)
-- Dependencies: 6
-- Name: categoria; Type: TABLE; Schema: dml; Owner: -; Tablespace: 
--

CREATE TABLE categoria (
    cod_categoria integer NOT NULL,
    desc_categoria character varying(50)
);


--
-- TOC entry 1855 (class 1259 OID 75689)
-- Dependencies: 6
-- Name: gravacao; Type: TABLE; Schema: dml; Owner: -; Tablespace: 
--

CREATE TABLE gravacao (
    cod_gravacao integer NOT NULL,
    cod_gravadora integer NOT NULL,
    cod_cantor integer NOT NULL,
    cod_musica integer NOT NULL,
    data_gravacao date
);


--
-- TOC entry 1851 (class 1259 OID 75664)
-- Dependencies: 6
-- Name: gravadora; Type: TABLE; Schema: dml; Owner: -; Tablespace: 
--

CREATE TABLE gravadora (
    cod_gravadora integer NOT NULL,
    nome_gravadora character varying(50),
    pais character varying(50)
);


--
-- TOC entry 1862 (class 1259 OID 75741)
-- Dependencies: 6
-- Name: fone; Type: TABLE; Schema: dml; Owner: -; Tablespace: 
--

CREATE TABLE fone (
    cod_fone integer NOT NULL,
    numero character varying(80),
    tipo character(1),
    cod_pessoa integer
);


--
-- TOC entry 1854 (class 1259 OID 75679)
-- Dependencies: 6
-- Name: musica; Type: TABLE; Schema: dml; Owner: -; Tablespace: 
--

CREATE TABLE musica (
    cod_musica integer NOT NULL,
    cod_categoria integer NOT NULL,
    duracao integer,
    titulo character varying(100)
);


--
-- TOC entry 1860 (class 1259 OID 75733)
-- Dependencies: 6
-- Name: pessoa; Type: TABLE; Schema: dml; Owner: -; Tablespace: 
--

CREATE TABLE pessoa (
    cod_pessoa integer NOT NULL,
    nome_pessoa character varying(70)
);

--
-- TOC entry 1861 (class 1259 OID 75739)
-- Dependencies: 1862 6
-- Name: fone_cod_fone_seq; Type: SEQUENCE; Schema: dml; Owner: -
--

CREATE SEQUENCE fone_cod_fone_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 2173 (class 0 OID 0)
-- Dependencies: 1861
-- Name: fone_cod_fone_seq; Type: SEQUENCE OWNED BY; Schema: dml; Owner: -
--

ALTER SEQUENCE fone_cod_fone_seq OWNED BY fone.cod_fone;


--
-- TOC entry 2174 (class 0 OID 0)
-- Dependencies: 1861
-- Name: fone_cod_fone_seq; Type: SEQUENCE SET; Schema: dml; Owner: -
--

SELECT pg_catalog.setval('fone_cod_fone_seq', 9, true);


--
-- TOC entry 1859 (class 1259 OID 75731)
-- Dependencies: 6 1860
-- Name: pessoa_cod_pessoa_seq; Type: SEQUENCE; Schema: dml; Owner: -
--

CREATE SEQUENCE pessoa_cod_pessoa_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 2175 (class 0 OID 0)
-- Dependencies: 1859
-- Name: pessoa_cod_pessoa_seq; Type: SEQUENCE OWNED BY; Schema: dml; Owner: -
--

ALTER SEQUENCE pessoa_cod_pessoa_seq OWNED BY pessoa.cod_pessoa;


--
-- TOC entry 2176 (class 0 OID 0)
-- Dependencies: 1859
-- Name: pessoa_cod_pessoa_seq; Type: SEQUENCE SET; Schema: dml; Owner: -
--

SELECT pg_catalog.setval('pessoa_cod_pessoa_seq', 9, true);


--
-- TOC entry 2137 (class 2604 OID 75744)
-- Dependencies: 1862 1861 1862
-- Name: cod_fone; Type: DEFAULT; Schema: dml; Owner: -
--

ALTER TABLE fone ALTER COLUMN cod_fone SET DEFAULT nextval('fone_cod_fone_seq'::regclass);


--
-- TOC entry 2136 (class 2604 OID 75736)
-- Dependencies: 1859 1860 1860
-- Name: cod_pessoa; Type: DEFAULT; Schema: dml; Owner: -
--

ALTER TABLE pessoa ALTER COLUMN cod_pessoa SET DEFAULT nextval('pessoa_cod_pessoa_seq'::regclass);


--
-- TOC entry 2163 (class 0 OID 75674)
-- Dependencies: 1853
-- Data for Name: cantor; Type: TABLE DATA; Schema: dml; Owner: -
--

INSERT INTO cantor (cod_cantor, nome_cantor, pais) VALUES (1, 'Marisa Monte', 'Brasil');
INSERT INTO cantor (cod_cantor, nome_cantor, pais) VALUES (2, 'Coldplay', 'Inglaterra');
INSERT INTO cantor (cod_cantor, nome_cantor, pais) VALUES (3, 'U2', 'Irlanda');
INSERT INTO cantor (cod_cantor, nome_cantor, pais) VALUES (4, 'Djavan', 'Brasil');
INSERT INTO cantor (cod_cantor, nome_cantor, pais) VALUES (5, 'Laura Pausini', 'Itália');
INSERT INTO cantor (cod_cantor, nome_cantor, pais) VALUES (6, 'Roberto Leal', 'Portugal');
INSERT INTO cantor (cod_cantor, nome_cantor, pais) VALUES (7, 'The Corrs', 'Estados Unidos');
INSERT INTO cantor (cod_cantor, nome_cantor, pais) VALUES (8, 'Legião Urbana', 'Brasil');
INSERT INTO cantor (cod_cantor, nome_cantor, pais) VALUES (9, 'Cazuza', 'Brasil');
INSERT INTO cantor (cod_cantor, nome_cantor, pais) VALUES (10, 'Tom Jobim', 'Brasil');
INSERT INTO cantor (cod_cantor, nome_cantor, pais) VALUES (11, 'Frank Sinatra', 'Estados Unidos');


--
-- TOC entry 2162 (class 0 OID 75669)
-- Dependencies: 1852
-- Data for Name: categoria; Type: TABLE DATA; Schema: dml; Owner: -
--

INSERT INTO categoria (cod_categoria, desc_categoria) VALUES (1, 'MPB');
INSERT INTO categoria (cod_categoria, desc_categoria) VALUES (2, 'Rock');
INSERT INTO categoria (cod_categoria, desc_categoria) VALUES (3, 'Vira');
INSERT INTO categoria (cod_categoria, desc_categoria) VALUES (4, 'Bossa Nova');
INSERT INTO categoria (cod_categoria, desc_categoria) VALUES (5, 'Jazz');
INSERT INTO categoria (cod_categoria, desc_categoria) VALUES (6, 'Pop rock');
INSERT INTO categoria (cod_categoria, desc_categoria) VALUES (7, 'Eletronic');
INSERT INTO categoria (cod_categoria, desc_categoria) VALUES (8, 'Pop');


--
-- TOC entry 2167 (class 0 OID 75741)
-- Dependencies: 1862
-- Data for Name: fone; Type: TABLE DATA; Schema: dml; Owner: -
--

INSERT INTO fone (cod_fone, numero, tipo, cod_pessoa) VALUES (1, '3333-1111', 'R', 1);
INSERT INTO fone (cod_fone, numero, tipo, cod_pessoa) VALUES (2, '4444-1111', 'C', 1);
INSERT INTO fone (cod_fone, numero, tipo, cod_pessoa) VALUES (3, '9999-1111', 'L', 1);
INSERT INTO fone (cod_fone, numero, tipo, cod_pessoa) VALUES (4, '3333-2222', 'R', 2);
INSERT INTO fone (cod_fone, numero, tipo, cod_pessoa) VALUES (5, '4444-2222', 'C', 2);
INSERT INTO fone (cod_fone, numero, tipo, cod_pessoa) VALUES (6, '9999-2222', 'L', 2);
INSERT INTO fone (cod_fone, numero, tipo, cod_pessoa) VALUES (7, '3333-3333', 'R', 3);
INSERT INTO fone (cod_fone, numero, tipo, cod_pessoa) VALUES (9, '8888-3333', 'L', 3);
INSERT INTO fone (cod_fone, numero, tipo, cod_pessoa) VALUES (8, '4444-3333', 'C', 3);


--
-- TOC entry 2165 (class 0 OID 75689)
-- Dependencies: 1855
-- Data for Name: gravacao; Type: TABLE DATA; Schema: dml; Owner: -
--

INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (1, 1, 1, 1, '2000-07-10');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (2, 1, 1, 2, '2000-12-07');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (3, 1, 1, 3, '2001-05-30');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (4, 3, 8, 4, '2005-12-29');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (5, 3, 8, 5, '1993-04-25');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (6, 3, 8, 6, '1989-01-31');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (7, 3, 8, 7, '1991-12-01');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (8, 3, 6, 8, '1988-07-30');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (9, 4, 10, 9, '1978-10-14');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (10, 4, 10, 10, '1975-08-11');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (11, 4, 10, 11, '1979-05-05');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (12, 4, 10, 12, '1981-04-18');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (13, 1, 2, 13, '2004-09-12');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (14, 1, 2, 14, '2004-09-20');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (16, 1, 2, 16, '2004-10-01');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (17, 4, 9, 17, '1986-06-30');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (18, 5, 9, 18, '1987-07-06');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (19, 1, 11, 19, '1971-08-29');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (20, 3, 5, 20, '1998-10-10');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (21, 5, 4, 21, '1995-01-20');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (22, 1, 3, 22, '1989-05-05');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (23, 1, 3, 23, '1991-10-20');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (24, 1, 3, 24, '1992-03-25');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (25, 5, 1, 25, '1998-10-20');
INSERT INTO gravacao (cod_gravacao, cod_gravadora, cod_cantor, cod_musica, data_gravacao) VALUES (15, 1, 2, 15, '2004-08-30');


--
-- TOC entry 2161 (class 0 OID 75664)
-- Dependencies: 1851
-- Data for Name: gravadora; Type: TABLE DATA; Schema: dml; Owner: -
--

INSERT INTO gravadora (cod_gravadora, nome_gravadora, pais) VALUES (1, 'Sony', 'Estados Unidos');
INSERT INTO gravadora (cod_gravadora, nome_gravadora, pais) VALUES (2, 'Som livre', 'Brasil');
INSERT INTO gravadora (cod_gravadora, nome_gravadora, pais) VALUES (3, 'EMI', 'Estados Unidos');
INSERT INTO gravadora (cod_gravadora, nome_gravadora, pais) VALUES (4, 'Globo', 'Brasil');
INSERT INTO gravadora (cod_gravadora, nome_gravadora, pais) VALUES (5, 'Trama', 'Brasil');


--
-- TOC entry 2164 (class 0 OID 75679)
-- Dependencies: 1854
-- Data for Name: musica; Type: TABLE DATA; Schema: dml; Owner: -
--

INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (1, 1, 240, 'Amor I love you');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (2, 1, 300, 'Não é fácil');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (3, 1, 250, 'Gentileza');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (4, 2, 500, 'Daniel na cova dos leões');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (5, 2, 322, 'Fábrica');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (6, 2, 440, 'Tempo perdido');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (7, 2, 312, 'Acrilic on canvas');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (8, 3, 298, 'Vira-vira');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (9, 4, 348, 'Chega de saudade');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (10, 4, 231, 'Luiza');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (11, 4, 355, 'Águas de março');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (12, 4, 250, 'Wave');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (13, 6, 333, 'Politik');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (14, 6, 225, 'Green eyes');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (15, 6, 440, 'A Rush of Blood to the head');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (16, 6, 320, 'Clocks');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (17, 6, 300, 'Codinome beija-flor');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (18, 6, 290, 'Faz parte do meu show');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (19, 5, 446, 'New York');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (20, 8, 299, 'Solitudine');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (21, 1, 430, 'Oceano');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (22, 2, 511, 'With or without you');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (23, 2, 300, 'Beautiful day');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (24, 2, 458, 'Bullet The Blue Sky');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (25, 1, 300, 'Sua');


--
-- TOC entry 2166 (class 0 OID 75733)
-- Dependencies: 1860
-- Data for Name: pessoa; Type: TABLE DATA; Schema: dml; Owner: -
--

INSERT INTO pessoa (cod_pessoa, nome_pessoa) VALUES (1, 'Ana');
INSERT INTO pessoa (cod_pessoa, nome_pessoa) VALUES (2, 'Beto');
INSERT INTO pessoa (cod_pessoa, nome_pessoa) VALUES (3, 'Carlos');
INSERT INTO pessoa (cod_pessoa, nome_pessoa) VALUES (4, 'Daniel');
INSERT INTO pessoa (cod_pessoa, nome_pessoa) VALUES (5, 'Eduardo');
INSERT INTO pessoa (cod_pessoa, nome_pessoa) VALUES (6, 'Flávio');
INSERT INTO pessoa (cod_pessoa, nome_pessoa) VALUES (7, 'Giuliana');
INSERT INTO pessoa (cod_pessoa, nome_pessoa) VALUES (8, 'Helena');
INSERT INTO pessoa (cod_pessoa, nome_pessoa) VALUES (9, 'Ivan');


--
-- TOC entry 2143 (class 2606 OID 75678)
-- Dependencies: 1853 1853
-- Name: cantor_pkey; Type: CONSTRAINT; Schema: dml; Owner: -; Tablespace: 
--

ALTER TABLE ONLY cantor
    ADD CONSTRAINT cantor_pkey PRIMARY KEY (cod_cantor);


--
-- TOC entry 2141 (class 2606 OID 75673)
-- Dependencies: 1852 1852
-- Name: categoria_pkey; Type: CONSTRAINT; Schema: dml; Owner: -; Tablespace: 
--

ALTER TABLE ONLY categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (cod_categoria);


--
-- TOC entry 2151 (class 2606 OID 75746)
-- Dependencies: 1862 1862
-- Name: fone_pkey; Type: CONSTRAINT; Schema: dml; Owner: -; Tablespace: 
--

ALTER TABLE ONLY fone
    ADD CONSTRAINT fone_pkey PRIMARY KEY (cod_fone);


--
-- TOC entry 2147 (class 2606 OID 75693)
-- Dependencies: 1855 1855
-- Name: gravacao_pkey; Type: CONSTRAINT; Schema: dml; Owner: -; Tablespace: 
--

ALTER TABLE ONLY gravacao
    ADD CONSTRAINT gravacao_pkey PRIMARY KEY (cod_gravacao);


--
-- TOC entry 2139 (class 2606 OID 75668)
-- Dependencies: 1851 1851
-- Name: gravadora_pkey; Type: CONSTRAINT; Schema: dml; Owner: -; Tablespace: 
--

ALTER TABLE ONLY gravadora
    ADD CONSTRAINT gravadora_pkey PRIMARY KEY (cod_gravadora);


--
-- TOC entry 2145 (class 2606 OID 75683)
-- Dependencies: 1854 1854
-- Name: musica_pkey; Type: CONSTRAINT; Schema: dml; Owner: -; Tablespace: 
--

ALTER TABLE ONLY musica
    ADD CONSTRAINT musica_pkey PRIMARY KEY (cod_musica);


--
-- TOC entry 2149 (class 2606 OID 75738)
-- Dependencies: 1860 1860
-- Name: pessoa_pkey; Type: CONSTRAINT; Schema: dml; Owner: -; Tablespace: 
--

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (cod_pessoa);

--
-- TOC entry 2160 (class 2606 OID 75747)
-- Dependencies: 2148 1862 1860
-- Name: fone_cod_pessoa_fkey; Type: FK CONSTRAINT; Schema: dml; Owner: -
--

ALTER TABLE ONLY fone
    ADD CONSTRAINT fone_cod_pessoa_fkey FOREIGN KEY (cod_pessoa) REFERENCES pessoa(cod_pessoa);


--
-- TOC entry 2158 (class 2606 OID 75699)
-- Dependencies: 1853 1855 2142
-- Name: gravacao_cod_cantor_fkey; Type: FK CONSTRAINT; Schema: dml; Owner: -
--

ALTER TABLE ONLY gravacao
    ADD CONSTRAINT gravacao_cod_cantor_fkey FOREIGN KEY (cod_cantor) REFERENCES cantor(cod_cantor);


--
-- TOC entry 2159 (class 2606 OID 75704)
-- Dependencies: 1851 2138 1855
-- Name: gravacao_cod_gravadora_fkey; Type: FK CONSTRAINT; Schema: dml; Owner: -
--

ALTER TABLE ONLY gravacao
    ADD CONSTRAINT gravacao_cod_gravadora_fkey FOREIGN KEY (cod_gravadora) REFERENCES gravadora(cod_gravadora);


--
-- TOC entry 2157 (class 2606 OID 75694)
-- Dependencies: 1855 1854 2144
-- Name: gravacao_cod_musica_fkey; Type: FK CONSTRAINT; Schema: dml; Owner: -
--

ALTER TABLE ONLY gravacao
    ADD CONSTRAINT gravacao_cod_musica_fkey FOREIGN KEY (cod_musica) REFERENCES musica(cod_musica);


--
-- TOC entry 2156 (class 2606 OID 75684)
-- Dependencies: 1854 2140 1852
-- Name: musica_cod_categoria_fkey; Type: FK CONSTRAINT; Schema: dml; Owner: -
--

ALTER TABLE ONLY musica
    ADD CONSTRAINT musica_cod_categoria_fkey FOREIGN KEY (cod_categoria) REFERENCES categoria(cod_categoria);


--
-- PostgreSQL database dump complete
--

