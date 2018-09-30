DECLARE @dest nvarchar(255)
SET @dest = 'F:\Archivos C\Mis Documentos\NetBeansProjects\TecSoft\TecSoft\Backups\TecSoft_' + CAST(DATEPART(weekday, GETDATE()) AS nvarchar(1)) + '.bak'
PRINT CAST (GETDATE() AS nvarchar) + ' - COPIA DE SEGURIDAD INICIADA AL ARCHIVO: ' + @dest
BACKUP DATABASE [dma] TO  DISK = @dest WITH NOFORMAT, NOINIT, 
NAME = N'dma-Full Database Backup', SKIP, NOREWIND, NOUNLOAD,  STATS = 10
GO