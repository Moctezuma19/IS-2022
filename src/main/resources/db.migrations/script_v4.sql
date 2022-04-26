ALTER TABLE `nota` ADD COLUMN `idUsuario` INT NOT NULL;
ALTER TABLE `nota` ADD CONSTRAINT `fk_idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario`(`idUsuario`);