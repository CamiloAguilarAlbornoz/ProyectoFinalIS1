SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


-- -----------------------------------------------------
-- Table `persona_tabla`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `persona_tabla` (
  `documento` INT NOT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `apellido` VARCHAR(255) NOT NULL,
  `direccion` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`documento`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


-- -----------------------------------------------------
-- Table `vehiculo_tabla`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vehiculo_tabla` (
  `placa` VARCHAR(255) NOT NULL,
  `marca` VARCHAR(255) NOT NULL,
  `anio` INT NOT NULL,
  `documento` INT NOT NULL,
  PRIMARY KEY (`placa`),
  CONSTRAINT `fk_conductor_tabla_persona_tabla1`
  	FOREIGN KEY (`documento`)
  	REFERENCES `persona_tabla` (`documento`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


-- -----------------------------------------------------
-- Table `conductor_tabla`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `conductor_tabla` (
  `documento` INT NOT NULL,
  `fecha_expedicion_licencia` DATE NOT NULL,
  `fecha_expiracion_licencia` DATE NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`documento`),
  CONSTRAINT `fk_conductor_tabla_persona_tabla`
  	FOREIGN KEY (`documento`)
  	REFERENCES `persona_tabla` (`documento`)
  ) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `agente_tabla` (
  `documento` INT NOT NULL,
  `estado` VARCHAR(45) NOT NULL,  
  PRIMARY KEY (`documento`),
  CONSTRAINT `fk_agente_tabla_persona_tabla`
    FOREIGN KEY (`documento`)
    REFERENCES `persona_tabla` (`documento`)
  ) ENGINE=MyISAM DEFAULT CHARSET=latin1;


-- -----------------------------------------------------
-- Table `multa_tabla`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `multa_tabla` (
  `id_multa_tabla` INT NOT NULL,
  `conductor_documento` INT NOT NULL,
  `agente_numero_agente` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `estado_multa` VARCHAR(45) NOT NULL,
  `valor_multa` INT NOT NULL,
  PRIMARY KEY (`id_multa_tabla`),
  CONSTRAINT `fk_multa_tabla_conductor_tabla1`
    FOREIGN KEY (`conductor_documento`)
    REFERENCES `conductor_tabla` (`persona_tabla_documento`),
  CONSTRAINT `fk_multa_tabla_agente_tabla1`
    FOREIGN KEY (`agente_numero_agente`)
    REFERENCES `agente_tabla` (`numero_agente`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;
