import logging
import sys

STR_FMT  = '%(asctime)s - %(levelname)+8s : %(message)s'
STR_FMT2 = '%(asctime)s - %(levelname)+8s : %(filename)-15s : %(lineno)04d : %(message)s'
DATE_FMT = '%d/%m/%Y %H:%M:%S'

logging.basicConfig(level=logging.INFO, format=STR_FMT, datefmt=DATE_FMT)
logging.info(sys.version)


sys.stderr = sys.__stdout__
