psql -U postgres -c "CREATE DATABASE mimic"
cd /build-scripts/
make mimic datadir=$datadir

