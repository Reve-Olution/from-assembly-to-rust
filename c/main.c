#include <stdio.h>
#include <string.h>

int main(void)
{
    char buff[6];
    char pass = 0;

    printf("\n Saisir le mot de passe : \n");
    gets(buff);

    if(strcmp(buff, "globaz"))
    {
        printf ("\n Mauvais mot de passe \n");
    }
    else
    {
        printf ("\n Mot de passe valide \n");
        pass = 1;
    }

    if(pass)
    {
        printf("%d\n", pass);
        printf ("\n Vous êtes administrateur du système! \n");
    }

    return 0;
}
