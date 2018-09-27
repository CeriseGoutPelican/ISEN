# ----------------------------
# Part 1 - import library
# 			and constant value
# -----------------------

# system library
import sys
import logging

#local library
import main1
#import library1


# constants
STR_FMT = '%(asctime)s - %(levelname)s : %(message)s'
DATE_FMT = '%d/%m/%Y %H:%M:%S'


# ----------------------------
# Part 2 - all functions
#
# -----------------------
from typing import Sequence, Any
def my_min(logger: logging.Logger, seq: Sequence) -> Any:
    """ What's this """
    return min(seq)


def divise(logger: logging.Logger, a: int, b:int) -> int:
    """ why should I have to fill this part """
    try:
        return a // b

    except Exception as e:
        logger.error(e)


def weird_function(logger: logging.Logger, a: int, b: int ,c: float) -> bool:
    """ weird function just to show if, else an elif instruction """

    logger.info("%s, %s, %s", str(a), str(b), str(c))
    if a > b:
        return True
    elif b > c:
        return False
    else:
        return a < b < c


def my_main(logger: logging.Logger, argv: list) -> None:
    """ """
    logger.info("Before call main1.my_main")
    main1.my_main()

    logger.info("min of {} is {}".format(argv,my_min(logger, argv)))

    for a,b in ((10, 3), (-5,0), ("tt",None)):
        # loop
        logger.debug("{} // {} -> {}".format(a, b, divise(logger, a, b)))

    logger.info("After call main1.my_main")
    logger.info(weird_function(logger,12, 34, 78.4))


# -----------------------
# Part 3 - main entry
# -----------------------
if __name__ == "__main__":
    """version
    """
    # is a comment
    # logging module is a module to produce message to handler with different level
    # A handler can be screen, file, event log (windows), database or mail, ...
    # See
    logging.basicConfig(level=logging.DEBUG, format=STR_FMT, datefmt=DATE_FMT)
    log = logging.getLogger()
    log.info(sys.version)

	# call main function with command line arguments
    my_main(log, sys.argv)
