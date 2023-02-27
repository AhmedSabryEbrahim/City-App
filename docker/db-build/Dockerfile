FROM python:3.9

RUN pip install mysql-connector-python


WORKDIR /usr/app/src

COPY db_populate_script.py ./

COPY cities.csv ./

