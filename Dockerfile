FROM nginx:latest
# Adding an a custom index.html from the content folder
ADD /frontend/public_html/index.html /usr/share/nginx/html/index.html
# Copying nginx.conf
COPY nginx.conf /etc/nginx/conf.d/default.conf
# Expose port
EXPOSE 80
EXPOSE 443
# Start nginx
CMD ["nginx", "-g", "daemon off;"]