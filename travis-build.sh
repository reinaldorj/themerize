#!/bin/bash
chmod +x grailsw
./grailsw clean
./grailsw refresh-dependencies --non-interactive
./grailsw compile
./grailsw compile --gsp
./grailsw test-app