# Control de Donaciones de Sangre

## Descripción

Este sistema está diseñado para ayudar a hospitales y bancos de sangre a gestionar de manera eficiente el registro de donadores de sangre, las citas y las campañas de donación. El programa busca mejorar el control, la rapidez, la seguridad y la eficiencia en el proceso de recolección de sangre.

El sistema permite gestionar los siguientes aspectos:

- **Registro de donadores.**
- **Registro de tipos de sangre de los donadores.**
- **Gestión de citas para donación.**
- **Administración de campañas de donación.**

## Propósito

El objetivo de este proyecto es crear una plataforma que facilite la gestión y control de las donaciones de sangre, asegurando una operación rápida, segura y bien organizada. Esto beneficia tanto a los hospitales y bancos de sangre como a los donantes, mejorando la experiencia de donación y garantizando que las campañas de sangre sean más efectivas.

## Características principales

### Registro de Donadores:
- Información personal (nombre, dirección, teléfono, etc.).
- Datos médicos relevantes (historial de salud, tipo de sangre, etc.).

### Gestión de Tipos de Sangre:
- Cada donador tendrá registrado su tipo de sangre.
- Los hospitales pueden hacer consultas para conocer qué tipos de sangre tienen disponibles.

### Citas para Donación:
- Los donantes pueden agendar citas para donar sangre.
- El sistema asegura que no haya citas duplicadas y que los donantes sean avisados con antelación.

### Campañas de Donación:
- Los hospitales y bancos de sangre pueden organizar campañas de donación en diversas ubicaciones.
- El sistema permite el registro de fechas, lugares y objetivos de la campaña.

### Notificaciones y Recordatorios:
- Los donantes recibirán recordatorios sobre sus citas y las campañas próximas.
- Notificaciones sobre la necesidad de donaciones de tipos de sangre específicos.

### Seguridad y Protección de Datos:
- Los datos de los donantes están protegidos con encriptación y medidas de seguridad para garantizar la privacidad.
- Acceso controlado por roles para permitir que solo personal autorizado gestione la información.

## Tecnologías utilizadas

### Backend:
- **Lenguaje**: Python (Flask o Django).
- **Base de Datos**: PostgreSQL o MySQL.
- **Autenticación**: JWT (JSON Web Tokens) o OAuth.

### Frontend:
- **Framework**: React.js o Angular.
- **Lenguaje**: JavaScript, HTML, CSS.

### Seguridad:
- Encriptación de datos con AES-256.
- HTTPS para todas las comunicaciones.

### Notificaciones:
- Servicios de correos electrónicos y SMS como Twilio o SendGrid.

## Instalación

### Requisitos previos:
- Tener instalado Python 3.x.
- Tener instalado Node.js (si se usa React o Angular).
- Tener acceso a una base de datos PostgreSQL o MySQL.

### Pasos para instalación:

1. Clonar el repositorio:

    ```bash
    git clone https://github.com/usuario/control-donaciones-sangre.git
    cd control-donaciones-sangre
    ```

2. Instalar las dependencias del backend:

    ```bash
    cd backend
    pip install -r requirements.txt
    ```

3. Instalar las dependencias del frontend:

    ```bash
    cd frontend
    npm install
    ```

4. Configurar la base de datos:
    - Crear una base de datos en PostgreSQL o MySQL.
    - Configurar las credenciales en el archivo de configuración del proyecto.

5. Ejecutar el servidor backend:

    ```bash
    cd backend
    python manage.py runserver
    ```

6. Ejecutar el servidor frontend:

    ```bash
    cd frontend
    npm start
    ```

## Pruebas

Para realizar pruebas, el sistema incluye una serie de test unitarios y de integración que pueden ejecutarse utilizando:

```bash
python manage.py test
